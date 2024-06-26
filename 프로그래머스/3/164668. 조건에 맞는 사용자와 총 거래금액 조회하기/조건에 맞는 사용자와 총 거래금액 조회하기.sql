-- 코드를 입력하세요
SELECT UGU.USER_ID, UGU.NICKNAME, SUM(UBG.PRICE) AS TOTAL_SALES
FROM USED_GOODS_USER UGU
JOIN USED_GOODS_BOARD UBG ON UGU.USER_ID = UBG.WRITER_ID
WHERE UBG.STATUS = 'DONE'
GROUP BY UGU.USER_ID HAVING TOTAL_SALES >= 700000
ORDER BY TOTAL_SALES ASC;