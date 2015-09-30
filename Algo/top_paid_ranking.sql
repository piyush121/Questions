-- rank
SELECT *
From (
SELECT t.genre_id, t.application_id, t.export_date_string, t.position
FROM (
Select g.genre_id, g.application_id, h.position, CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END as export_date_string
From (
SELECT genre_id, application_id
FROM genre_application
WHERE genre_id in (6005, 6007, 6013, 6014, 6016) AND is_primary = 1
AND application_id not in (select application_id from application_001_deleted)
) as g
INNER JOIN rss_toppaidipadapplications_genre__history h ON (g.application_id = h.application_id AND h.country = 'US'
and CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END between '2015-01-26' and '2015-07-26')
) as t
UNION
SELECT t.genre_id, t.application_id, t.export_date_string, t.position
FROM (
Select g.genre_id, g.application_id, h.position, CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END as export_date_string
From (
SELECT genre_id, application_id
FROM genre_application
WHERE genre_id in (6005, 6007, 6013, 6014, 6016) AND is_primary = 1
AND application_id not in (select application_id from application_002_deleted)
) as g
INNER JOIN rss_toppaidipadapplications_genre__history h ON (g.application_id = h.application_id AND h.country = 'US'
and CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END between '2015-01-26' and '2015-07-26')
) as t
UNION
SELECT t.genre_id, t.application_id, t.export_date_string, t.position
FROM (
Select g.genre_id, g.application_id, h.position, CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END as export_date_string
From (
SELECT genre_id, application_id
FROM genre_application
WHERE genre_id in (6005, 6007, 6013, 6014, 6016) AND is_primary = 1
AND application_id not in (select application_id from application_003_deleted)
) as g
INNER JOIN rss_toppaidipadapplications_genre__history h ON (g.application_id = h.application_id AND h.country = 'US'
and CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END between '2015-01-26' and '2015-07-26')
) as t
UNION
SELECT t.genre_id, t.application_id, t.export_date_string, t.position
FROM (
Select g.genre_id, g.application_id, h.position, CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END as export_date_string
From (
SELECT genre_id, application_id
FROM genre_application
WHERE genre_id in (6005, 6007, 6013, 6014, 6016) AND is_primary = 1
AND application_id not in (select application_id from application_004_deleted)
) as g
INNER JOIN rss_toppaidipadapplications_genre__history h ON (g.application_id = h.application_id AND h.country = 'US'
and CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END between '2015-01-26' and '2015-07-26')
) as t
UNION
SELECT t.genre_id, t.application_id, t.export_date_string, t.position
FROM (
Select g.genre_id, g.application_id, h.position, CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END as export_date_string
From (
SELECT genre_id, application_id
FROM genre_application
WHERE genre_id in (6005, 6007, 6013, 6014, 6016) AND is_primary = 1
AND application_id not in (select application_id from application_005_deleted)
) as g
INNER JOIN rss_toppaidipadapplications_genre__history h ON (g.application_id = h.application_id AND h.country = 'US'
and CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END between '2015-01-26' and '2015-07-26')
) as t
UNION
SELECT t.genre_id, t.application_id, t.export_date_string, t.position
FROM (
Select g.genre_id, g.application_id, h.position, CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END as export_date_string
From (
SELECT genre_id, application_id
FROM genre_application
WHERE genre_id in (6005, 6007, 6013, 6014, 6016) AND is_primary = 1
AND application_id not in (select application_id from application_006_deleted)
) as g
INNER JOIN rss_toppaidipadapplications_genre__history h ON (g.application_id = h.application_id AND h.country = 'US'
and CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END between '2015-01-26' and '2015-07-26')
) as t
UNION
SELECT t.genre_id, t.application_id, t.export_date_string, t.position
FROM (
Select g.genre_id, g.application_id, h.position, CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END as export_date_string
From (
SELECT genre_id, application_id
FROM genre_application
WHERE genre_id in (6005, 6007, 6013, 6014, 6016) AND is_primary = 1
AND application_id not in (select application_id from application_008_deleted)
) as g
INNER JOIN rss_toppaidipadapplications_genre__history h ON (g.application_id = h.application_id AND h.country = 'US'
and CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END between '2015-01-26' and '2015-07-26')
) as t
UNION
SELECT t.genre_id, t.application_id, t.export_date_string, t.position
FROM (
Select g.genre_id, g.application_id, h.position, CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END as export_date_string
From (
SELECT genre_id, application_id
FROM genre_application
WHERE genre_id in (6005, 6007, 6013, 6014, 6016) AND is_primary = 1
AND application_id not in (select application_id from application_009_deleted)
) as g
INNER JOIN rss_toppaidipadapplications_genre__history h ON (g.application_id = h.application_id AND h.country = 'US'
and CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END between '2015-01-26' and '2015-07-26')
) as t
UNION
SELECT t.genre_id, t.application_id, t.export_date_string, t.position
FROM (
Select g.genre_id, g.application_id, h.position, CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END as export_date_string
From (
SELECT genre_id, application_id
FROM genre_application
WHERE genre_id in (6005, 6007, 6013, 6014, 6016) AND is_primary = 1
AND application_id not in (select application_id from application_010_deleted)
) as g
INNER JOIN rss_toppaidipadapplications_genre__history h ON (g.application_id = h.application_id AND h.country = 'US'
and CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END between '2015-01-26' and '2015-07-26')
) as t
UNION
SELECT t.genre_id, t.application_id, t.export_date_string, t.position
FROM (
Select g.genre_id, g.application_id, h.position, CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END as export_date_string
From (
SELECT genre_id, application_id
FROM genre_application
WHERE genre_id in (6005, 6007, 6013, 6014, 6016) AND is_primary = 1
AND application_id not in (select application_id from application_011_deleted)
) as g
INNER JOIN rss_toppaidipadapplications_genre__history h ON (g.application_id = h.application_id AND h.country = 'US'
and CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END between '2015-01-26' and '2015-07-26')
) as t
UNION
SELECT t.genre_id, t.application_id, t.export_date_string, t.position
FROM (
Select g.genre_id, g.application_id, h.position, CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END as export_date_string
From (
SELECT genre_id, application_id
FROM genre_application
WHERE genre_id in (6005, 6007, 6013, 6014, 6016) AND is_primary = 1
AND application_id not in (select application_id from application_012_deleted)
) as g
INNER JOIN rss_toppaidipadapplications_genre__history h ON (g.application_id = h.application_id AND h.country = 'US'
and CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END between '2015-01-26' and '2015-07-26')
) as t
UNION
SELECT t.genre_id, t.application_id, t.export_date_string, t.position
FROM (
Select g.genre_id, g.application_id, h.position, CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END as export_date_string
From (
SELECT genre_id, application_id
FROM genre_application
WHERE genre_id in (6005, 6007, 6013, 6014, 6016) AND is_primary = 1
AND application_id not in (select application_id from application_013_deleted)
) as g
INNER JOIN rss_toppaidipadapplications_genre__history h ON (g.application_id = h.application_id AND h.country = 'US'
and CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END between '2015-01-26' and '2015-07-26')
) as t
UNION
SELECT t.genre_id, t.application_id, t.export_date_string, t.position
FROM (
Select g.genre_id, g.application_id, h.position, CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END as export_date_string
From (
SELECT genre_id, application_id
FROM genre_application
WHERE genre_id in (6005, 6007, 6013, 6014, 6016) AND is_primary = 1
AND application_id not in (select application_id from application_014_deleted)
) as g
INNER JOIN rss_toppaidipadapplications_genre__history h ON (g.application_id = h.application_id AND h.country = 'US'
and CASE WHEN LENGTH(h.export_date)=13 THEN DATE(from_unixtime(h.export_date/1000))
ELSE DATE(from_unixtime(h.export_date)) END between '2015-01-26' and '2015-07-26')
) as t
) as z
group by z.genre_id,z.application_id ,z.export_date_string
INTO OUTFILE '/home/yvi/top_grossing_ranking.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '"' LINES TERMINATED BY '\n';
