package com.service.whatap_test.util;

import com.service.whatap_test.domain.UserDomain;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import javax.xml.stream.events.Characters;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;

class ParsingUtilTest {

    @Test
    void initAndParseFile() throws Exception {
        String DIRECTORY = "D:\\study\\library\\user.txt";
        ConcurrentHashMap<Integer, UserDomain> userMap = new ConcurrentHashMap<>();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(DIRECTORY))))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() > 0) {
                    line = line.replaceAll(" ", "");
                    String[] split = line.split(",");
                    Integer id = Integer.parseInt(split[0]);
                    StringBuilder paymentStrBuilder = new StringBuilder();
                    String paymentStr = split[4];

                    if (paymentStr.isEmpty()) {
                        paymentStr = split[5];
                    }

                    for (Character character : paymentStr.toCharArray()) {
                        if (Character.isDigit(character)) {
                            paymentStrBuilder.append(character);
                        }
                    }

                    UserDomain userDomain = new UserDomain(
                            id,
                            split[1],
                            Integer.parseInt(split[2]),
                            split[3],
                            Integer.parseInt(paymentStrBuilder.toString())
                    );
                    userMap.put(id, userDomain);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}