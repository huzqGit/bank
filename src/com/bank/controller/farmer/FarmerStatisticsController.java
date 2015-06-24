package com.bank.controller.farmer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.service.IFarmerStatisticsService;

@Controller
@RequestMapping(value = "/farmer")
public class FarmerStatisticsController {
	
	@Resource
	private IFarmerStatisticsService farmerStatisticsService;
	
	@RequestMapping(value = "/queryFarmerNum",method = RequestMethod.GET)
	public ModelAndView queryFarmerNum(HttpServletRequest request, 
			HttpServletResponse response){
		List<Map<String,String>> farmerNum =farmerStatisticsService.queryFarmerNum();
		ModelAndView view = new ModelAndView("/farmer/farmerNumStatistics");
		view.addObject("farmerNums",farmerNum);
		return view;
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/queryBigLender",method = RequestMethod.GET)
	public ModelAndView queryBigLender(HttpServletRequest request, 
			HttpServletResponse response){
		String village = request.getParameter("village");
		if(StringUtils.isEmpty(village) || village.equals("0")){
			village = null;
		}
		String type = request.getParameter("type");
		if(type == null){
			type ="1";
		}
		String qno = request.getParameter("no");
		int no = qno== null?50:Integer.parseInt(qno);
		List<Map> lenders = farmerStatisticsService.queryBigLender(village,type,no);
		ModelAndView view = new ModelAndView("/farmer/farmerBigLender");
		view.addObject("lenders",lenders);
		view.addObject("village",village==null?"0":village);
		view.addObject("type",type);
		return view;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/queryIncomes",method = RequestMethod.GET)
	public ModelAndView queryIncomes(HttpServletRequest request, 
			HttpServletResponse response){
		String year = request.getParameter("year");
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		year = year== null?format.format(new Date()):year;
		List<Map> incomes = farmerStatisticsService.queryIncome(year);
		Map map = new HashMap();
		double farmingIncome =0;
		double avocationIncome  = 0;
		double businessIncome = 0;
		double workIncome = 0;
		double otherIncome = 0;
		double totalIncome = 0;
		for(Map income:incomes){
			farmingIncome = farmingIncome+(Double)income.get("FARMINGINCOME");
			avocationIncome = avocationIncome+(Double)income.get("AVOCATIONINCOME");
			businessIncome = businessIncome+(Double)income.get("BUSINESSINCOME");
			workIncome = workIncome+(Double)income.get("WORKINCOME");
			otherIncome = otherIncome+(Double)income.get("OTHERINCOME");
			totalIncome = totalIncome+(Double)income.get("TOTALINCOME");
		}
		map.put("VILLAGE", "全县合计");
		map.put("FARMINGINCOME", farmingIncome);
		map.put("AVOCATIONINCOME", avocationIncome);
		map.put("BUSINESSINCOME", businessIncome);
		map.put("WORKINCOME", workIncome);
		map.put("OTHERINCOME", otherIncome);
		map.put("TOTALINCOME", totalIncome);
		ModelAndView view = new ModelAndView("/farmer/farmerIncomes");
		view.addObject("incomes",incomes);
		return view;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/queryPayments",method = RequestMethod.GET)
	public ModelAndView queryPayments(HttpServletRequest request, 
			HttpServletResponse response){
		String year = request.getParameter("year");
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		year = year== null?format.format(new Date()):year;
		List<Map> payments = farmerStatisticsService.queryPayment(year);
		Map map = new HashMap();
		double productPay =0;
		double livingPay = 0;
		double medicalPay = 0;
		double educatePay = 0;
		double insuredPay = 0;
		double otherPay = 0;
		double totalPay = 0;
		for(Map payment:payments){
			productPay = productPay+(Double)payment.get("PRODUCTPAY");
			livingPay = livingPay+(Double)payment.get("LIVINGPAY");
			medicalPay = medicalPay+(Double)payment.get("MEDICALPAY");
			educatePay = educatePay+(Double)payment.get("EDUCATEPAY");
			insuredPay = insuredPay+(Double)payment.get("INSUREDPAY");
			otherPay = otherPay+(Double)payment.get("OTHERPAY");
			totalPay = totalPay+(Double)payment.get("TOTALPAY");
		}
		map.put("VILLAGES", "全县合计");
		map.put("PRODUCTPAY", productPay);
		map.put("LIVINGPAY", livingPay);
		map.put("MEDICALPAY", medicalPay);
		map.put("EDUCATEPAY", educatePay);
		map.put("INSUREDPAY", insuredPay);
		map.put("OTHERPAY", otherPay);
		map.put("TOTALPAY", totalPay);
		ModelAndView view = new ModelAndView("/farmer/farmerPayments");
		view.addObject("payments",payments);
		return view;
	}
}
