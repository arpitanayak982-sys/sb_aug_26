package com.jt.expense_tracker;

import java.time.LocalDate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    private JdbcTemplate jdbcTemplate;

    public ExpenseController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @RequestMapping(value = "/expenses", method = RequestMethod.GET)
    public void getExpenses() {

        String sql = "SELECT * FROM expenses";

        jdbcTemplate.query(sql, (resultSet) -> {
            // System.out.println("id is " + resultSet.getInt("id"));
            // System.out.println("title is " + resultSet.getString("title"));
            // System.out.println("category is " + resultSet.getString("category"));

           
        //Expense expense =new Expense ();
        //expense.setId(resultSet.getInt("id"));
        var id=resultSet.getInt("id");
         String title=resultSet.getString("title");
          var category=resultSet.getString("category");
           Double  price=resultSet.getDouble("price");
            LocalDate date =resultSet.getDate("date").toLocalDate();
            var expense =new Expense ( id,title,category,price,date);
            

        


    
        });
    }
}