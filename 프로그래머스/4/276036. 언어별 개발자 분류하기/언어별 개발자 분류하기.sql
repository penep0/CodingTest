WITH
  fe AS (
    SELECT BIT_OR(CODE) AS mask
    FROM SKILLCODES
    WHERE CATEGORY = 'Front End'
  ),
  py AS (
    SELECT CODE AS mask
    FROM SKILLCODES
    WHERE NAME = 'Python'
  ),
  cs AS (
    SELECT CODE AS mask
    FROM SKILLCODES
    WHERE NAME = 'C#'
  )
SELECT
  CASE
    WHEN (D.SKILL_CODE & fe.mask) > 0 AND (D.SKILL_CODE & py.mask) > 0 THEN 'A'
    WHEN (D.SKILL_CODE & cs.mask) > 0 THEN 'B'
    WHEN (D.SKILL_CODE & fe.mask) > 0 THEN 'C'
  END AS GRADE,
  D.ID,
  D.EMAIL
FROM DEVELOPERS D
CROSS JOIN fe
CROSS JOIN py
CROSS JOIN cs
WHERE
  ((D.SKILL_CODE & fe.mask) > 0 AND (D.SKILL_CODE & py.mask) > 0)
  OR (D.SKILL_CODE & cs.mask) > 0
  OR (D.SKILL_CODE & fe.mask) > 0
ORDER BY GRADE, D.ID;