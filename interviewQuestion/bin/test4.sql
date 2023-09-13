use sys;


CREATE TABLE Department (
    DeptID INT PRIMARY KEY,
    Name VARCHAR(255)
);

INSERT INTO Department (DeptID, Name)
VALUES
    (1, 'SALES'),
    (2, 'HR'),
    (3, 'FINANCE'),
    (4, 'DEV'),
    (5, 'QC');

SELECT *  FROM Department;

CREATE TABLE Employ (
    EmployID INT PRIMARY KEY,
    Name VARCHAR(255),
    DeptID INT
);

--     FOREIGN KEY (DeptID) REFERENCES Department(DeptID)

INSERT INTO Employ (EmployID, Name, DeptID)
VALUES
    (1, 'Tom',1),
    (2, 'Mary', 1),
    (3, 'JohnEmploy', 2),
    (4, 'David', 3),
    (5, 'Jason', 3),
    (6, 'Ray',6);

SELECT * FROM Employ;
ALTER TABLE Employ
ADD CONSTRAINT employ_ibfk_1
FOREIGN KEY (DeptID) REFERENCES Department(DeptID);

-- result 1
SELECT E.EmployID ,E.NAME ,COALESCE( D.NAME,'NULL') AS DepartmentName
FROM Employ E 
left join Department D 
on E.DEPTID = D.DEPTID;


-- result 2
SELECT D.NAME AS DepartmentName ,
COALESCE( COUNT(E.EmployID) , 0) AS "NO OF STAFF"
FROM Department D  
left join EMPLOY E 
on E.DEPTID = D.DEPTID
GROUP BY D.NAME;

-- RESULT 3
SELECT 
	COALESCE(D.NAME,"UNKNOWN") AS DepartmentName ,
	COALESCE( COUNT(E.EmployID) , 0) AS "NO OF STAFF"
FROM Department D  
left join EMPLOY E 
on E.DEPTID = D.DEPTID
GROUP BY COALESCE( D.NAME,"UNKNOWN")
UNION ALL

SELECT 'Unknown' AS DepartmentName, COUNT(*) AS "No Of Staffs"
FROM Employ
WHERE DeptID NOT IN (SELECT DeptID FROM  Department);


