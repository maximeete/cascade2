package servlet;

import com.alibaba.fastjson.JSON;
import lists.SmallTypeList;
import javabeans.SmallType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletDeal",urlPatterns = "/check")
public class ServletDeal extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bigId = request.getParameter("bigId");
        SmallTypeList smallTypeList = new SmallTypeList();
        List<SmallType> list = smallTypeList.queryAll(bigId);
        String json = JSON.toJSONString(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(json);
    }
}
