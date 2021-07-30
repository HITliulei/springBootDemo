package com.ll.adminServer;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Lei
 * @version 0.1
 * @date 2021/7/30
 */

@SpringBootApplication
@EnableAdminServer
public class AdminServerMain {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerMain.class);
    }
}
