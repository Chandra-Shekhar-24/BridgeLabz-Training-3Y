# Object Modeling: Relationships and Communication Diagrams

## Overview

This document presents visual diagrams for object modeling problems focusing on different types of relationships:

- **Aggregation** (◇): "Has-a" relationship where objects can exist independently
- **Composition** (◆): Strong "part-of" relationship where child objects cannot exist without parent
- **Association** (→): Objects are related but maintain their independence

---

## Assisted Problems

### Problem 1: Library and Books (Aggregation)

```
┌─────────────┐              ┌─────────────┐
│   Library   │◇─────────────│    Book     │
├─────────────┤  1      0..*├─────────────┤
│ - name      │              │ - title     │
│ - books[]   │              │ - author    │
├─────────────┤              ├─────────────┤
│ + addBook() │              │ + getTitle()│
│ + removeBook│              │ + getAuthor()│
│ + display() │              └─────────────┘
└─────────────┘

Relationship: Aggregation
- Books can exist without libraries
- Same book can be in multiple libraries
- Library "has" books but doesn't own them
```

### Problem 2: Bank and Account Holders (Association)

```
┌─────────────┐              ┌─────────────┐
│    Bank     │←─────────────→│  Customer   │
├─────────────┤  1      0..*├─────────────┤
│ - name      │              │ - name      │
│ - bankCode  │              │ - customerId│
│ - customers[]              │ - balance   │
├─────────────┤              │ - bank      │
│ + addCustomer()            ├─────────────┤
│ + display() │              │ + openAccount()
└─────────────┘              │ + viewBalance()
                              │ + deposit() │
                              │ + withdraw()│
                              └─────────────┘

Relationship: Association
- Customers and banks exist independently
- Bidirectional relationship
- Communication through methods
```

### Problem 3: Company and Departments (Composition)

```
┌─────────────┐              ┌─────────────┐              ┌─────────────┐
│   Company   │◆─────────────│ Department  │◆─────────────│  Employee   │
├─────────────┤  1      1..*├─────────────┤  1      1..*├─────────────┤
│ - name      │              │ - name      │              │ - name      │
│ - departments[]            │ - employees[]              │ - position  │
├─────────────┤              │ - company   │              │ - department│
│ + createDept()             ├─────────────┤              ├─────────────┤
│ + dissolve()│              │ + hireEmp() │              │ + terminate()│
└─────────────┘              │ + dissolve()│              └─────────────┘
                              └─────────────┘

Relationship: Composition
- Departments cannot exist without company
- Employees cannot exist without department
- When company is deleted, all parts are deleted
```

---

## Self Problems

### Self Problem 1: School, Students, and Courses

```
           ┌─────────────┐
           │   School    │
           ├─────────────┤
           │ - name      │
           │ - students[]│
           │ - courses[] │
           ├─────────────┤
           │ + admitStudent()
           │ + offerCourse()
           └─────────────┘
                  │◇
                  │ 1
                  │
           ┌──────▼──────┐                    ┌─────────────┐
           │   Student   │←──────────────────→│   Course    │
           ├─────────────┤  many        many ├─────────────┤
           │ - name      │                   │ - courseCode│
           │ - studentId │                   │ - courseName│
           │ - courses[] │                   │ - students[]│
           ├─────────────┤                   ├─────────────┤
           │ + enroll()  │                   │ + enroll() │
           │ + viewCourses()                 │ + showStudents()
           └─────────────┘                   └─────────────┘

Relationships:
- School ◇ Student: Aggregation (students can exist without school)
- Student ↔ Course: Many-to-many Association
```

### Self Problem 2: University, Faculties, and Departments

```
┌─────────────┐              ┌─────────────┐              ┌─────────────┐
│ University  │◆─────────────│ Department  │◇─────────────│   Faculty   │
├─────────────┤  1      1..*├─────────────┤  1      0..*├─────────────┤
│ - name      │              │ - name      │              │ - name      │
│ - departments[]            │ - faculty[] │              │ - specialization
│ - allFaculty[]             │ - university│              │ - facultyId │
├─────────────┤              ├─────────────┤              ├─────────────┤
│ + createDept()             │ + assignFac()              │ + toString()│
│ + hireFaculty()            │ + close()   │              └─────────────┘
│ + close()   │              └─────────────┘
└─────────────┘

Relationships:
- University ◆ Department: Composition (departments die with university)
- Department ◇ Faculty: Aggregation (faculty can exist independently)
- University hires faculty, departments assign them
```

### Self Problem 3: Hospital, Doctors, and Patients

```
              ┌─────────────┐
              │  Hospital   │
              ├─────────────┤
              │ - name      │
              │ - doctors[] │
              │ - patients[]│
              ├─────────────┤
              │ + addDoctor()│
              │ + admitPatient()
              └─────────────┘
                     │◇
              ┌──────┴──────┐
              │             │
       ┌──────▼──────┐      │         ┌─────────────┐
       │   Doctor    │←─────┼────────→│   Patient   │
       ├─────────────┤      │  many   ├─────────────┤
       │ - name      │      │   many  │ - name      │
       │ - doctorId  │      │         │ - patientId │
       │ - specialization   │         │ - ailment   │
       │ - patients[]│      │         │ - doctors[] │
       ├─────────────┤      │         ├─────────────┤
       │ + consult() │      │         │ + request() │
       │ + viewPatients()   │         │ + viewHistory()
       └─────────────┘      │         └─────────────┘
                           ▼
                   Communication Flow:
                   Patient → requestConsultation()
                   Doctor → consult() → dialogue
                   Both → update relationship lists

Relationships:
- Hospital ◇ Doctor/Patient: Aggregation
- Doctor ↔ Patient: Many-to-many Association with communication
```

### Self Problem 4: E-commerce Platform

```
┌─────────────┐              ┌─────────────┐              ┌─────────────┐
│EcommercePlatform           │   Customer  │              │    Order    │
├─────────────┤              ├─────────────┤  1      0..*├─────────────┤
│ - name      │              │ - customerId│←─────────────┤ - orderId   │
│ - customers[]              │ - name      │              │ - customer  │
│ - products[]│              │ - email     │              │ - items[]   │
│ - orders[]  │              │ - orderHistory[]            │ - orderDate │
├─────────────┤              ├─────────────┤              │ - status    │
│ + register()│              │ + placeOrder()             ├─────────────┤
│ + addProduct()             │ + sendNotify()             │ + addProduct()
└─────────────┘              │ + viewHistory()            │ + calculate()
       │◇                    └─────────────┘              │ + process() │
       │                              │                   │ + ship()    │
       ▼                              │                   └─────────────┘
┌─────────────┐              ┌────────▼──────┐                   │◇
│   Product   │              │   OrderItem   │                   │
├─────────────┤              ├─────────────┤                    │ 0..*
│ - productId │◇─────────────┤ - product   │                    │
│ - name      │  1      1..*├─────────────┤                    ▼
│ - price     │              │ - quantity  │            ┌─────────────┐
│ - stock     │              │ - subtotal  │            │   Product   │
├─────────────┤              ├─────────────┤            ├─────────────┤
│ + isAvailable()            │ + getSubtotal()          │ (same as    │
│ + reduceStock()            └─────────────┘            │  above)     │
└─────────────┘                                        └─────────────┘

Relationships:
- Customer → Order: One-to-many Association
- Order ◇ Product: Aggregation through OrderItem
- Communication: Customer ↔ Platform notifications
```

### Self Problem 5: University Management System

```
                    ┌─────────────┐
                    │ University  │
                    ├─────────────┤
                    │ - name      │
                    │ - students[]│
                    │ - professors│
                    │ - courses[] │
                    ├─────────────┤
                    │ + manage()  │
                    └─────────────┘
                           │◇
                    ┌──────┴──────┐
                    │             │
            ┌───────▼──────┐      │              ┌─────────────┐
            │   Student    │      │              │   Course    │
            ├─────────────┤      │              ├─────────────┤
            │ - studentId │      │       ┌─────→│ - courseId  │
            │ - name      │      │       │      │ - courseName│
            │ - courses[] │      │       │      │ - students[]│
            ├─────────────┤      │       │      │ - professor │
            │ + enrollCourse()   │       │      ├─────────────┤
            │ + viewCourses()    │       │      │ + enroll()  │
            └─────────────┘      │       │      │ + assign()  │
                    │            │       │      └─────────────┘
                    │ many       │       │             │
                    │            │       │             │ 1
                    ▼            │       │             ▼
            ┌─────────────┐      │       │      ┌─────────────┐
            │ Enrollment  │      │       │      │ Professor   │
            ├─────────────┤      │       └──────┤ - profId    │
            │ - student   │      │              │ - name      │
            │ - course    │      │              │ - courses[] │
            │ - grade     │      │              ├─────────────┤
            ├─────────────┤      │              │ + teach()   │
            │ + enroll()  │      │              │ + assign()  │
            └─────────────┘      │              └─────────────┘
                                │                      ▲
                                └──────────────────────┘

Relationships:
- University ◇ Student/Professor/Course: Aggregation
- Student ↔ Course: Many-to-many through Enrollment
- Professor → Course: One-to-many Association
- Communication: enrollCourse(), assignProfessor() methods
```

---

## Relationship Summary

| Problem | Primary Relationship | Key Characteristics |
|---------|---------------------|-------------------|
| Library-Books | Aggregation | Books exist independently, can be shared |
| Bank-Customer | Association | Bidirectional, independent existence |
| Company-Department | Composition | Strong ownership, lifecycle dependency |
| School-Student-Course | Mixed | Aggregation + Many-to-many Association |
| University-Faculty-Dept | Mixed | Composition + Aggregation |
| Hospital-Doctor-Patient | Association | Many-to-many with communication |
| E-commerce | Mixed | Customer-Order + Order-Product relationships |
| University Management | Association | Complex many-to-many relationships |

## Legend

- **◇** Aggregation (hollow diamond)
- **◆** Composition (filled diamond) 
- **→** Association (arrow)
- **↔** Bidirectional Association
- **1, 0..*, many** Cardinality indicators