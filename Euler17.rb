

def num_to_words(num)
	ones = ["", "one", "two", "three", "four", "five", 
		"six", "seven", "eight", "nine"]
	tenths = ["ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"]
	tens = ["", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]
	num = num.to_s.split("").map{|i| i.to_i}
	while num.size < 4
		num.unshift 0
	end
	num
	if num[0] != 0
		p "One thousand"
	elsif num[1] != 0
		s = ones[num[1]] + " hundred "
		if num[2] == 0 and num[3] == 0
			p s
		elsif num[2] != 0 and num[2] < 2
			s += " and " + tenths[(num[2].to_s + num[3].to_s).to_i - 10]
			p s
		else
			s += " and " + tens[num[2]] + " " + ones[num[3]]
			p s
		end
	elsif num[2] != 0 
		if num[2] < 2
			p tenths[(num[2].to_s + num[3].to_s).to_i - 10]
		else
			p tens[num[2]] + "-" + ones[num[3]]
		end
	else
		p ones[num[3]]
	end
end

a = []
num_to_words(342)
1.upto(1000) { |i| a << num_to_words(i).strip.gsub(" ", "").gsub("-", "") }

p a.map{|i| i.size}.inject(:+)