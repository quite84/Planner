package com.planner.planner.commonService.impl;

import org.springframework.stereotype.Service;

import com.planner.planner.commonService.Sha256EncoderService;

@Service
public class Sha256EncoderServiceImpl implements Sha256EncoderService{

	public String toHexString(byte[] hash) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
	
}
