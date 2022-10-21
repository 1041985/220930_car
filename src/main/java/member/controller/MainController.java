package member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import car.model.CarBean;
import car.model.CarDao;
import category.model.CategoryBean;
import category.model.CategoryDao;


@Controller
public class MainController {
   
   private final String command = "main.mem";
   private final String getPage = "/main2";
   
   @Autowired(required = false)
   CategoryDao catedao;
   
	
	@Autowired(required = false)
	CarDao cdao;
	
   
   @RequestMapping(command)
   public String main(HttpServletRequest request, Model model) {
      
      List<CategoryBean> modLists= catedao.getList();
      List<CategoryBean> comLists = catedao.getComList();
   
		
		System.out.println("제발");
		List<CarBean> lists = cdao.selectAllCarInMain();
		System.out.println("되라");
		model.addAttribute("lists", lists);
        model.addAttribute("modLists", modLists);
        model.addAttribute("comLists", comLists);
      
        return getPage;
   }
   
   
}