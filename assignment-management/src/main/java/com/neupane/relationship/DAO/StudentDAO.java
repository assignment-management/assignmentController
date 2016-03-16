/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.relationship.DAO;

import com.neupane.relationship.entity.Student;
import java.util.List;

/**
 *
 * @author parlad
 */
public interface StudentDAO {

    List<Student> getAll();

    int insert(Student s);

    Student getById(int id);

}
