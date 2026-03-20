package com.kfc.controller;

import java.util.Map;
import java.util.Collections;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Utils;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@CrossOrigin(origins = "*") // Note: Restrict this to your frontend URL in production!
@RestController
public class RazorPayController {
	
    @Value("${RAZORPAY_KEY_ID}")
    private String keyId;

    @Value("${RAZORPAY_KEY_SECRET}")
    private String keySecret;

    @PostMapping(value = "/createorder", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createOrder( @RequestBody Map<String, Object> data) {
        try {
            int amount = Integer.parseInt(data.get("amount").toString());

            RazorpayClient razorpay = new RazorpayClient(keyId, keySecret);

            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount * 100); 
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", "txn_" + System.currentTimeMillis()); 

            Order order = razorpay.orders.create(orderRequest);

            return ResponseEntity.ok(order.toString());
            
        } catch (RazorpayException e) {
            System.err.println("Razorpay Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Could not create order"));
        }
    }
    
    @PostMapping(value = "/payment/verify", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> verifyPayment(@RequestBody Map<String, String> data) {
        try {
            JSONObject options = new JSONObject();
            options.put("razorpay_order_id", data.get("razorpay_order_id"));
            options.put("razorpay_payment_id", data.get("razorpay_payment_id"));
            options.put("razorpay_signature", data.get("razorpay_signature"));

            boolean isValid = Utils.verifyPaymentSignature(options, keySecret);

            if (isValid) {
                return ResponseEntity.ok(Collections.singletonMap("status", "Payment Successful"));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Collections.singletonMap("error", "Invalid Signature"));
            }
        } catch (RazorpayException e) {
            System.err.println("Verification Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Verification failed due to server error"));
        }
    }
}