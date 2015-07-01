list = 12..28123

def is_abundant num
    sum = 1
    2.upto(Math.sqrt(num)).each do |n|
        if num % n == 0
            sum += n
            if n < num/n
                sum += num/n
            end
        end
    end
    sum > num
end

def can_be_written abs, num
    i = 0
    j = abs.length - 1
    while i <= j
    left = abs[i]
    right = abs[j]
        if left > num
            break
        end
        if left + right < num
            i += 1
        elsif left + right > num
            j -= 1
        else
            #p left.to_s + " + " + right.to_s 
            return true
        end
    end
    return false
end

abundant_numbers = []

12.upto(28123).each do |number|
    if is_abundant number
        abundant_numbers << number
    end
end

#p abundant_numbers
#exit
sum = 0
1.upto(28123).each do |number| 
    if !can_be_written(abundant_numbers, number)
        #p number.to_s + ": true"
        sum += number
    end
end
p "Final sum: " + sum.to_s

#p abundant_numbers

