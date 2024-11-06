package com.all_day_notes.controller.Sample.employee;

//2
import java.util.List;

//1
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//2
import org.springframework.web.bind.annotation.GetMapping;
//3
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.all_day_notes.entity.sample_entity.Employee;
import com.all_day_notes.service.sample_service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	//1
	 private final EmployeeService employeeService;

	    @Autowired
	    public EmployeeController(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }
	
	//2
	//http://localhost:8080/employee/list
    @GetMapping("/list")
    public String showList(Model model) {
        // Serviceを呼び出し、Model属性にセットします
        List<Employee> employees = this.employeeService.findAllEmployee();
        model.addAttribute("employees", employees);
        return "sample/employee/list";
    }
    
    
    //3
    //http://localhost:8080/employee/find/{任意の値} (1)
    // データの1件取得
    @GetMapping("/find/{employeeId}")
    public String showEmployee(@PathVariable Integer employeeId, Model model) {
        // Serviceを呼び出し、Model属性にセットします
        Employee employee = this.employeeService.findEmployee(employeeId);
        model.addAttribute("employee", employee);
        return "sample/employee/data";
    }
    
    
    //4
    //http://localhost:8080/employee/searchByName/山田
    @GetMapping("/searchByName/{name}")
    public String searchEmployee(@PathVariable String name, Model model) {
        List<Employee> employees = this.employeeService.findByName(name);
        model.addAttribute("employees", employees);
        // データの全件取得時に作成したテンプレートファイルを流用します。
        return "sample/employee/list";
    }
    
    
    //5
    //http://localhost:8080/employee/create?name=山田&department=第一開発事業部
    //http://localhost:8080/employee/update/7?name=加藤&department=第二開発事業部
    // 冒頭で述べた通り、一般的にはPOST通信によりデータ挿入が行われます
    @GetMapping("/create")
    public String addEmployee(@RequestParam("name") String name
                              , @RequestParam("department") String department) {
        // データを挿入します
        this.employeeService.insert(name, department);
        // 一覧ページにリダイレクト(後述)します
        return "redirect:/employee/list	";
    }
    
    
    //6
    //http://localhost:8080/employee/delete/7
    @GetMapping("/delete/{employeeId}")
    public String deleteEmployee(@PathVariable Integer employeeId) {
        // データを削除します
        this.employeeService.delete(employeeId);
        // 一覧ページにリダイレクトします
        return "redirect:/employee/list";
    }

}
