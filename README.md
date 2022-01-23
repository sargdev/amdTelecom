# amdTelecom

Four assessments

--------- Assessment 1 
Create a function (findSeven) that takes an array of numbers and return "Found"
if the character 7 appears in the array of the numbers. Otherwise, return "there is no 7 in the array".

>>> Run: test/Assessment1Test

---------- Assessment 2 
Create a function (digitSum) that accepts an integer and calculates the sum of its digits.

If the sum is greater than 9 repeats the calculation of the sum of its digits until we get sum < 10.
 
Returns the final sum.

>>> Run: test/Assessment2Test

-----------Assessment 3 
Create a function (doRemake) that takes a string of words and

- Move the first letter of each word to the end of the word.
- Add "ay" to the end of the word.
- Words starting with a vowel (a,e,i,o,u, A, E, I, O, U) simply have "way" appended to the end.

Be sure to preserve proper capitalization and punctuation.

>>> Run: test/Assessment3Test

-----------Assessment 4 
As a User I want a mechanism capable to examine whether data and depending on the temperature send an sms message to a specified number.

Use Weather Api from https://openweathermap.org/  to access current weather data for the Thessaloniki.

API documentation https://openweathermap.org/api

Use the endpoint api.openweathermap.org for your API calls

For the api calls use the key

b385aa7d4e568152288b3c9f5c2458a5

If the temperature is greater than 20C send SMS message to +30 6922222222 with text "Your name and Temperature more than 20C. <the actual temperature>" else send sms message to +30  6922222222 with text "Your name and Temperature less than 20C. <the actual temperature>"

where <the actual temperature> the temperature that the weather api returns for Thessaloniki.

Repeat the above procedure every 10 minutes for 10 times and then stop.

>>> Run: test/Assessment4Test
 // FYI: code will run for 10*10 minutes in a new thread in order not to block main thread for such a long time.
 // That's why I have put a Thread.sleep for 5 seconds, just to log info for the first sent sms.
