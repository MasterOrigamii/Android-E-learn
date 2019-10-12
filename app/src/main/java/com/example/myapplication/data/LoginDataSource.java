package com.example.myapplication.data;

import com.example.myapplication.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            // 在这里验证用户账号和密码

            LoggedInUser fakeUser = null;

            if(username.equals("17301127")){
                if(password.equals("luoyao")){
                    // TODO: 根据账号寻找用户名
                    String displayName = "lipu";

                    // 根据用户ID和用户名创建新实例，注意这里username为用户ID
                    fakeUser = new LoggedInUser(username, displayName);


                }
            }

            return new Result.Success<>(fakeUser);

        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}
