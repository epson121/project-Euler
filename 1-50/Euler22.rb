file = File.open("p022_names.txt")
lines = []

file.each_line do |l|
    lines << l.gsub("\"", "").split(",")
end

counter = 1
val = 0
sorted_lines = lines[0].sort()
sorted_lines.each do |item|
  item.each_byte do |b| 
    val += (b - 64) * counter
  end
  counter += 1
end
#871198282
p val;
