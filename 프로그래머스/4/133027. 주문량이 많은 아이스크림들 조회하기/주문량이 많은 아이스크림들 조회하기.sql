-- 코드를 입력하세요
SELECT F.FLAVOR
FROM FIRST_HALF AS F
INNER JOIN JULY AS J
ON F.FLAVOR = J.FLAVOR
GROUP BY FLAVOR
ORDER BY SUM(F.TOTAL_ORDER + J.TOTAL_ORDER) DESC
LIMIT 3