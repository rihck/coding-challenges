-- https://leetcode.com/problems/invalid-tweets/?envType=study-plan-v2&envId=top-sql-50

SELECT tweet_id
FROM Tweets
WHERE CHAR_LENGTH(content) > 15;

SELECT tweet_id
FROM Tweets
WHERE LENGTH(content) > 15;

#     Reference:
# https://stackoverflow.com/questions/1734334/mysql-length-vs-char-length?rq=1
#
# LENGTH() returns the length of the string measured in bytes.
# CHAR_LENGTH() returns the length of the string measured in characters.
# This is especially relevant for Unicode, in which most characters are encoded in two bytes, or UTF-8, where the number of bytes varies.
#
#     Example:
#
# SELECT LENGTH('€')  # is equal to 3
# SELECT CHAR_LENGTH('€') # is equal to 1

/**
  Schema

  Table: Tweets

    +----------------+---------+
    | Column Name    | Type    |
    +----------------+---------+
    | tweet_id       | int     |
    | content        | varchar |
    +----------------+---------+
    In SQL, tweet_id is the primary key for this table.
    This table contains all the tweets in a social media app.
 */

/**
  I/O

  Example 1:

    Input:
    Tweets table:
    +----------+----------------------------------+
    | tweet_id | content                          |
    +----------+----------------------------------+
    | 1        | Vote for Biden                   |
    | 2        | Let us make America great again! |
    +----------+----------------------------------+
    Output:
    +----------+
    | tweet_id |
    +----------+
    | 2        |
    +----------+
    Explanation:
    Tweet 1 has length = 14. It is a valid tweet.
    Tweet 2 has length = 32. It is an invalid tweet.

 */