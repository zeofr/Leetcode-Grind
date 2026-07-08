# 1683. Invalid Tweets

## 💡 My Approach
Main Concept : `LENGTH()` , `CHAR_LENGTH()`,`CHARACTER_LENGTH()`

- The `LENGTH()` calculates number of bytes in string whereas
-  `CHAR_LENGTH()`,`CHARACTER_LENGTH()` calculates the number of characters.

Example :

SELECT CHAR_LENGTH('😊');
Output: 1

Even though the emoji occupies 4 bytes in UTF-8, it is still one character.

---

_Official problem description unavailable._