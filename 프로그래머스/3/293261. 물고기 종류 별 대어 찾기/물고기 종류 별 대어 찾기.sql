-- 코드를 작성해주세요
select id, n.fish_name, length
from fish_info as i
inner join fish_name_info as n on i.fish_type = n.fish_type
inner join (
    select fish_name, max(length) as max_length
    from fish_info as i
    inner join fish_name_info as n on i.fish_type = n.fish_type
    group by fish_name
) as m on n.fish_name = m.fish_name AND i.length = m.max_length
order by id asc
