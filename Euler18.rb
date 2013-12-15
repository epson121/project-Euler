class Node 
	attr_accessor :left, :right, :value

	def initialize(value)
		@value = value
	end

	def to_s
		"Value : " + @value.to_s
	end
end

# open file
# split lines
file = File.open("18_triangle.txt")
lines = []
file.each_line do |l|
	lines << l.gsub("\n", "").split(" ").map{|i| i.to_i}
end

#create list of nodes
nodes = []
for i in 0..lines.length-1
	lines[i].each do |elem|		
		n = Node.new(elem)
		nodes << n
	end
end

#assign left and right for nodes
counter = 0
i = 1
so_far = 0
limit = 1
nodes.each do |node|
	node.left = nodes[counter + i]
	node.right = nodes[counter + i + 1]
	counter += 1
	so_far += 1
	if so_far == limit
		limit += 1
		so_far = 0
		i += 1
	end
end

=begin
void postorder(struct node* node){
        if (node == NULL)
                return;

        postorder(node->left);
        postorder(node->right);
        cout << node->data << endl;
}
=end


def trav(node)
	if node == nil
		return
	end
	if node.left != nil
		if node.left.value > node.right.value
			return node.value + trav(node.left)
		else
			return node.value + trav(node.right)
		end
	end
	return node.value
end

p trav(nodes[0])

def printPaths(node) 
	path = []
  	printPathsRecur(node, path, 0);
 end

def printPathsRecur(node, path, pathLen) 
	if (node==nil) 
		return;
	end

	path[pathLen] = node.value;
	pathLen += 1;

	if node.left == nil && node.right == nil 
		countSize(path, pathLen);
	else
		printPathsRecur(node.left, path, pathLen);
		printPathsRecur(node.right, path, pathLen);
	end
end

Sizes = []

def countSize(ints,len)
    Sizes << ints.inject(:+)
end

def maxRootLeaf(node, total, a, sum)
    if(node == nil)
        return
    end
    
    sum = sum + node.value
    if (sum > total.value and node.left == nil && node.right == nil)
    	total.value = sum
    	a << node.value
    end
    maxRootLeaf(node.left, total, a, sum)
    maxRootLeaf(node.right, total, a, sum)

=begin
    ls = maxRootLeaf(root.left)
    rs = maxRootLeaf(root.right)
    if ls > rs
    	return root.value + ls
    else
    	return root.value + rs
    end
=end	
end

a = []
a[0] = nodes[0].value
total = Node.new(0)
p maxRootLeaf(nodes[0], total, a, 0)
=begin

int a[2];
    a[0]=root->data;
	
	preorder(root,total,a,0);

void preorder(bst *node,bst *total,int a[2],int sum)
{
    if(node==NULL)
		return;
    
    sum=sum+node->data;
    if(sum>total->data&&node->lchild==NULL&&node->rchild==NULL)
    {
		total->data=sum;
		a[1]=node->data;
	}
    preorder(node->lchild,total,a,sum);
 
   preorder(node->rchild,total,a,sum);
 
   
}
	
=end


#printPaths(nodes[0])
#p Sizes.max

#p maxRootLeaf(nodes[0])



#p nodes[0].left

#def postorder(Node)

