# Insurance management platform
This project has three domain models, Client, InsurancePolicy and Claims.
All the models have their respective JPArepositories and controllers to perform all the t RESTful API calls.
# Features
The given RESTful APIs can perform all the required CRUD operations whithot any error.
It can create, read, update and delete the database with the APIs in it.
# Relationship between models
The relationship between the models are of type @OneTOMany and @ManyToOne.
# Architecture
Spring Data JPA is used in the persistence layer and MySQL is used as the database.
# Problems to fix
The relationship is not established properly, so you might face some trouble while going through it. Though, it could be solved with a little bit of work.
