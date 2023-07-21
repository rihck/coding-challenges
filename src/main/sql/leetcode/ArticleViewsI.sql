-- https://leetcode.com/problems/article-views-i/?envType=study-plan-v2&envId=top-sql-50

/**
  Schema

  Table: Views
    +---------------+---------+
    | Column Name   | Type    |
    +---------------+---------+
    | article_id    | int     |
    | author_id     | int     |
    | viewer_id     | int     |
    | view_date     | date    |
    +---------------+---------+
    The table may have duplicate rows (In other words, there is no primary key for this table in SQL).
    Each row of this table indicates that some viewer viewed an article (written by some author) on some date.
    Note that equal author_id and viewer_id indicate the same person.
 */

/**
  I/O
    Example 1:

    Input:
    Views table:
    +------------+-----------+-----------+------------+
    | article_id | author_id | viewer_id | view_date  |
    +------------+-----------+-----------+------------+
    | 1          | 3         | 5         | 2019-08-01 |
    | 1          | 3         | 6         | 2019-08-02 |
    | 2          | 7         | 7         | 2019-08-01 |
    | 2          | 7         | 6         | 2019-08-02 |
    | 4          | 7         | 1         | 2019-07-22 |
    | 3          | 4         | 4         | 2019-07-21 |
    | 3          | 4         | 4         | 2019-07-21 |
    +------------+-----------+-----------+------------+
    Output:
    +------+
    | id   |
    +------+
    | 4    |
    | 7    |
    +------+
 */