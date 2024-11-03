-- 코드를 작성해주세요
select count(*) as fish_count
from fish_info as i
inner join fish_name_info as n on n.fish_type = i.fish_type
where n.fish_name = 'BASS' or n.fish_name = 'SNAPPER'
