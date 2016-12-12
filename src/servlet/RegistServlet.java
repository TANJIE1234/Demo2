package servlet;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rpsw = request.getParameter("rpsw");//得到表单输入的内容
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        if(username==null||username.trim().isEmpty()){
            request.setAttribute("msg", "帐号不能为空");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }
        if(phone==null||phone.trim().isEmpty()){
            request.setAttribute("msg", "电话不能为空");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }
        if(email==null||email.trim().isEmpty()){
            request.setAttribute("msg", "邮箱不能为空");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }
        if(password==null||password.trim().isEmpty()){
            request.setAttribute("msg", "密码不能为空");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }
        if(!password.equals(rpsw)){
            request.setAttribute("msg", "两次输入的密码不同");
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
            return;
        }
        User newUser = new User(username,password,phone,email);
        UserDao u = new UserDao();
        u.addUser(newUser);//调用addUser（）方法
        request.setAttribute("msg", "恭喜："+username+"，注册成功");
        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

}

