package mall.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import car.model.CarBean;
import car.model.CarDao;
import mall.model.PaySuccessBean;

//�ֹ��� ����
@Controller
public class MallOrderDetailController {

   private final String command = "orderDetail.mall";
   private String getPage = "/orderDetail";
   
   @Autowired
   private CarDao carDao;

   @RequestMapping(command)
   public String orderDetail(HttpSession session, Model model, HttpServletRequest req) {
      PaySuccessBean paySuccessBean = (PaySuccessBean) session.getAttribute("paySuccessBean");
      List<CarBean> carList = (ArrayList<CarBean>) session.getAttribute("carList");
      String nowStr = (String) session.getAttribute("nowStr");

      session.setAttribute("paySuccessBean", paySuccessBean);
      session.setAttribute("carList", carList);
      session.setAttribute("nowStr", nowStr);
      
      model.addAttribute("cnum", req.getParameter("cnum"));

      return getPage;
   }
}