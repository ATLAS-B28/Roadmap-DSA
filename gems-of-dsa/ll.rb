class Node
  attr_accessor :value, :next_node
  def initialize(value)
    @value = value
    @next_node = nil
  end
end

class LL
  def initialize
    @head = nil
    @tail = nil
  end

  def add_node(value)
    new_node = Node.new(value)

    if @head.nil?
      @head = new_node
      @tail = new_node
    else
      @tail.next_node = new_node
      @tail = new_node
    end
end

 def remove_node(value)
   curr_node = @head
   prev_node = nil

   while curr_node
     if curr_node.value == value
       if prev_node.nil?
         @head = curr_node.next_node
       else
         prev_node.next_node = curr_node.next_node
       end

       if curr_node == @tail
         @tail = prev_node
       end

      return
    end

    prev_node = curr_node
    curr_node = curr_node.next_node
   end

  end

  def print_list
   curr_node = @head

   while curr_node
     puts curr_node.value
     curr_node = curr_node.next_node

    end
  end
end

list = LL.new
list.add_node(1)
list.add_node(2)
list.add_node(3)
list.print_list
list.remove_node(2)
list.print_list
