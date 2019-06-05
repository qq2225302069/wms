package com.wms.util;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by cyh on 2019/5/22.
 */
public class JWTToken implements AuthenticationToken {
        private String token;

        public JWTToken(String token) {
            this.token = token;
        }

        public Object getPrincipal() {
            return token;
        }

        public Object getCredentials() {
            return token;
        }

}
