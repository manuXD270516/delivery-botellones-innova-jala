package com.cainco.bootcamp.system.config;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class Validaciones {
	
	public boolean validaCarnet(String carnet){
        boolean sw=true;
        Pattern pat = Pattern.compile("[0-9]{6,8}[a-zA-Z]{2}|[0-9]{6,8}");
        Matcher mat = pat.matcher(carnet);
        if (!mat.matches()) {
            sw=false;
        }
        return sw;

    }

}
