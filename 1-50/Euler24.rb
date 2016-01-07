# simple oneliner in Ruby
=begin
a = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
a.permutation.to_a.map {|e| e.join("").to_i}.sort[999999]
=end

# SEPA algorithm
# $rs = []

# def swap str, a, b
#     temp = str[a]
#     str[a] = str[b]
#     str[b] = temp
#     s = str.clone
#     if !$rs.include? s
#         $rs << s
#     end
#     return str
# end


# def permute str, len

#    key = len-1
#    newkey = len-1

#    while ((key > 0) and (str[key] <= str[key-1])) do
#     key -= 1
#    end
#    key -= 1

#    if( key < 0 )
#       return 0
#    end

#    newkey = len-1
#    while ((newkey > key) and (str[newkey] <= str[key])) do
#     newkey -= 1
#    end
#    str = swap(str, key, newkey)

#    len -= 1
#    key += 1

#    while(len>key) do
#       str = swap(str,len,key)
#       key += 1
#       len -= 1
#     end
# end

# str = "0123456789"
# c = 0
# while c < 10000000 do
#     permute(str, str.length())
#     c += 1
# end

# p $rs.sort[999999]

#Alexander Bogomolyn's unordered permutation algorithm
$level = -1
$r = []
def visit(value, n, k)
  $level += 1
  value[k] = $level

  if ($level == n)
    $r << value.clone
  else
    for i in 0..(n-1)
      if (value[i] == 0)
        visit(value, n, i)
      end
    end
  end
  $level -= 1
  value[k] = 0
end

visit([0, 0, 0, 0, 0, 0, 0, 0, 0, 0], 10, 0)

p $r.sort[0]