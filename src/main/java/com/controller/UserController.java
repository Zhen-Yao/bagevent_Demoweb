package com.controller;

import com.entity.User;
import com.entity.Userloginlog;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    //登录，转发到登录页面
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String getUserByEmail(String email,String cellphone,String password,String num,HttpServletRequest request){
        User user;
        if(num.equals("1")){
            user=userService.getUserByEmail(email);

        }else{
            user=userService.getUserByCellphone(cellphone);
        }
        if(user!=null) {
            String state = Integer.toString(user.getState());
            String MD5_password = getMD5(password,state);
            if(MD5_password.equals(user.getPassword())){
                //向Userloginlog表中加数据
                Userloginlog userloginlog = new Userloginlog();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
                userloginlog.setLoginTime(df.format(new Date()));// new Date()为获取当前系统时间
                try {
                    InetAddress ip4 = Inet4Address.getLocalHost();
                    userloginlog.setLoginIp(ip4.getHostAddress());
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                userloginlog.setUserId(user.getUserId());
                userService.addUserLoginlog(userloginlog);

                //展现数据
                List<Userloginlog> list = userService.getalluserloginlog();
                System.out.println(list);
                request.getSession().setAttribute("list", list);
                return "redirect:/index";//成功重定向到首页
            }else{
                return "error";
            }
        }else {
            return "error";
        }
    }
    //首页
    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String ToIndex() {
        return "index";
    }
    @RequestMapping("/registered")
    public String addPerson(int userid,String username,String email,String cellphone,String password){
        User user = new User();
        user.setUserId(userid);
        user.setUserName(username);
        user.setEmail(email);
        user.setCellphone(cellphone);
        user.setSalt("0");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        user.setCreateTime(df.format(new Date()));// new Date()为获取当前系统时间
        int state = (int)(1+Math.random()*(10-1+1));
        user.setState(state);
        String a = Integer.toString(state);
        String MD5_password = getMD5(password,a);
        user.setPassword(MD5_password);
        userService.addUser(user);
        return "success";
    }

    public static String getMD5(String str,String slat) {
        String base = str +"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }


}
