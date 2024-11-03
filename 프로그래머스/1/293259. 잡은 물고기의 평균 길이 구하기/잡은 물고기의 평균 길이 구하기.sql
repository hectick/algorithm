-- 코드를 작성해주세요
select round(((select count(*) from fish_info where length is null)*10 + sum(length)) / count(*), 2) as average_length
from fish_info
