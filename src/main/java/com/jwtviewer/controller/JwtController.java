package com.jwtviewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JwtController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/decode")
    public String decodeJwt(@RequestParam("jwtToken") String jwtToken,
                            @RequestParam(value = "jwtType", defaultValue = "signed") String jwtType,
                            Model model) {
        String headerJson = "";
        String payloadJson = "";
        String error = null;
        try {
            String[] parts = jwtToken.split("\\.");
            if (parts.length < 2) {
                throw new IllegalArgumentException("JWT must have at least header and payload");
            }
            java.util.Base64.Decoder decoder = java.util.Base64.getUrlDecoder();
            String header = new String(decoder.decode(parts[0]));
            String payload = new String(decoder.decode(parts[1]));
            headerJson = header;
            payloadJson = payload;
            if ("signed".equals(jwtType)) {
                // Try to verify signature (optional: add key input for real verification)
                if (parts.length == 3 && parts[2].length() > 0) {
                    // Just mark as signed for now; actual verification requires key
                }
            }
        } catch (Exception e) {
            error = "Invalid JWT or unable to decode.";
        }
        model.addAttribute("jwtToken", jwtToken);
        model.addAttribute("headerJson", headerJson);
        model.addAttribute("payloadJson", payloadJson);
        model.addAttribute("error", error);
        return "index";
    }
}
