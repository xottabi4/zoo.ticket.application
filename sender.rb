require 'rest-client'
require 'json'

puts 'Enter zoneName: '
zone = gets.chomp
puts 'Enter price: '
price = gets.chomp
url = 'http://localhost:8080/ticket'
payload = {zone: zone, price: price}
headers = {'Content-Type': 'text/json'}
puts  RestClient.post(url, payload, headers)

