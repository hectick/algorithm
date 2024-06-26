-- 코드를 작성해주세요
select 
    emp_no,
    emp_name,
    grade,
    case when grade = 'S' then sal * 0.2
        when grade = 'A' then sal * 0.15
        when grade = 'B' then sal * 0.1
        else 0
    end as bonus
from hr_employees as e
    join (
        select
            emp_no,
            case when avg(score) >= 96 then 'S'
                when avg(score) >= 90 then 'A'
                when avg(score) >= 80 then 'B'
                else 'C'
            end as grade
        from hr_grade
        group by emp_no, year
    ) as tmp using(emp_no)
order by emp_no