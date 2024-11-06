package com.all_day_notes.service.sample_service;

//1
import java.util.List;
//3
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//2
import com.all_day_notes.entity.sample_entity.Employee;
import com.all_day_notes.repository.sample_repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	//1
    // Repositoryをフィールドに用意する
    private final EmployeeRepository employeeRepository;

    // コンストラクタでRepositoryをインジェクションします
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    // ビジネスロジック用のメソッドを以降に定義します
    
    //2
    // 全件取得処理
    // メソッド名はRepositoryの処理や最終的な返り値がわかるような名前にしましょう
    public List<Employee> findAllEmployee() {
        // employeesテーブルのデータをemployeeオブジェクトにつめて全件取得する
        return this.employeeRepository.findAll();
    }
    
    //3 
    // 主キーでの1件検索
    public Employee findEmployee(Integer employeeId) {
        // データの1件取得
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(employeeId);
        // OptionalからEntityクラスの取得を試みる
        Employee employee = optionalEmployee.get();
        return employee;
    }
    
    //4
    // 絞り込み検索
    public List<Employee> findByName(String name) {
        return this.employeeRepository.findByName(name);
    }
    
    
    /*
     * 5
     * データの保存や削除はよく登録フォームからの
     * POSTデータの送信によって行われますが、
     * 今回はデータ操作に必要な知識習得にフォーカスするために
     * 全てGET通信により行います。
     * 
     * データベースへのデータ挿入
     * 
     */

    // 新規登録処理
    public Employee insert(String name, String department) {
        // 保存したいEntityクラスのインスタンスを作成する
        Employee employee = new Employee();

        // 引数で受けたname, departmentをEmployeeオブジェクトにセットします
        employee.setName(name);
        employee.setDepartment(department);

        // データベースに保存する
        return this.employeeRepository.save(employee);
    }
    
    /*
     * 
     */
    // 更新処理
    public Employee update(Integer employeeId, String name, String department) {
        // 更新したいデータを取得する
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(employeeId);
        Employee employee = optionalEmployee.get();

        // Entityクラスのフィールドに更新内容をセットする
        employee.setName(name);
        employee.setDepartment(department);

        // データベースに保存する
        return this.employeeRepository.save(employee);
    }
    
    // 削除処理
    public void delete(Integer id) {
        this.employeeRepository.deleteById(id);
    }
    

}
