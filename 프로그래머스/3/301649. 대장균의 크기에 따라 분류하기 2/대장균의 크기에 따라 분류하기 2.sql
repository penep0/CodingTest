SELECT 
    ID,
    CASE
        WHEN RN <= TOTAL * 0.25 THEN 'CRITICAL'
        WHEN RN <= TOTAL * 0.50 THEN 'HIGH'
        WHEN RN <= TOTAL * 0.75 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM (
    SELECT 
        ID,
        SIZE_OF_COLONY,
        @row := @row + 1 AS RN,
        @total AS TOTAL
    FROM ECOLI_DATA,
         (SELECT @row := 0) r,
         (SELECT @total := COUNT(*) FROM ECOLI_DATA) t
    ORDER BY SIZE_OF_COLONY DESC
) A
ORDER BY ID;