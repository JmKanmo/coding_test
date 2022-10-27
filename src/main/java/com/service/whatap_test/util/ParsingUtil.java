package com.service.whatap_test.util;

import com.service.whatap_test.domain.UserDomain;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


public class ParsingUtil {
    private static final String DIRECTORY = "D:\\study\\library\\user.txt";
    private static final ConcurrentHashMap<Integer, UserDomain> userMap = new ConcurrentHashMap<>();

    static {
        initAndParseFile();
    }


    // static
    public static void initAndParseFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(DIRECTORY))))) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                if (line.length() > 0) {
                    line = line.replaceAll(" ", "");
                    String[] split = line.split(",");
                    Integer id = Integer.parseInt(split[0]);
                    StringBuilder paymentStrBuilder = new StringBuilder();
                    String paymentStr = split[4];
                    // 로그 기록 필요
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

    public static List<UserDomain> findUserJson() {
        List<UserDomain> userDomainList = new ArrayList<>();
        userMap.forEach((key, value) -> {
            userDomainList.add(value);
        });
        return userDomainList;
    }

    public static UserDomain findUser(int id) {
        return userMap.get(id);
    }

    public static boolean deleteUser(int id) {
        try {
            if (userMap.get(id) == null) {
                throw new RuntimeException("user not find");
            }
            userMap.remove(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<UserDomain> findUserByName(String name) {
        List<UserDomain> resultList = new ArrayList<>();

        userMap.forEach((key, value) -> {
            if (value.getName().contains(name)) {
                resultList.add(value);
            }
        });
        return resultList;
    }
}
