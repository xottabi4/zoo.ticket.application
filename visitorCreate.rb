require 'rest-client'
require 'json'

puts 'Enter visitor name: '
name = gets.chomp
puts 'Enter visitor surname: '
surname = gets.chomp
puts 'Enter visitor age: '
age = gets.chomp
url = 'http://localhost:8080/visitor'
payload = {name: name, surname: surname, age: age}
headers = {'Content-Type': 'text/json'}
puts  RestClient.post(url, payload, headers)



