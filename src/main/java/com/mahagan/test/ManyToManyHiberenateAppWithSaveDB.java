package com.mahagan.test;

import com.mahagan.domain.Employees;
import com.mahagan.domain.Projects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ManyToManyHiberenateAppWithSaveDB {

        public static void main(String[] args) {
            StandardServiceRegistry ssrr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(ssrr).getMetadataBuilder().build();

            SessionFactory factory = metadata.getSessionFactoryBuilder().build();
            Session session = factory.openSession();
            Transaction txs = session.beginTransaction();

            Employees employees = new Employees();
            employees.setEmpName("ajay");
            employees.setEmpAddress("pue");



            Projects project = new Projects();
            project.setProjectVersion("5.64");
            project.setProjectDomain("civil");
            project.setProjectName("site m");


            project.getEmployees().add(employees);
            employees.getProjects().add(project);
            session.persist(employees);



            Employees employees1 = (Employees) session.get(Employees.class, 1);
            System.out.println("Employee get called");
            System.out.println("Employee ID="+employees1.getEmpId());
            System.out.println("Employee ID="+employees1.getEmpAddress());
            System.out.println("Employee ID="+employees1.getEmpName());
            System.out.println("Employee get details.........>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            Projects projects1 = (Projects) session.get(Projects.class,1) ;
            System.out.println("project domain"+projects1.getProjectDomain());
            System.out.println("project domain"+projects1.getProjectVersion());
            System.out.println("project domain"+projects1.getProjectName());
            txs.commit();
            session.close();

            System.out.println("data save and fetched at a time ");
        }

    }
