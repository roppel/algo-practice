class BinaryTree:
    def __init__(self, value, left=None, right=None, parent=None):
        self.value = value
        self.left = left
        self.right = right
        self.parent = parent

def findSuccessor(tree, node):
    if node.right is not None:
        return getLeftMostChild(node.right)
    return getRightMostParent(node)

def getLeftMostChild(node):
    while node.left is not None:
        node = node.left
    return node

def getRightMostParent(node):
    while node.parent is not None and node.parent.right == node:
        node = node.parent
    return node.parent


root = BinaryTree(1)
root.left = BinaryTree(2)
root.left.parent = root
root.right = BinaryTree(3)
root.right.parent = root
root.left.left = BinaryTree(4)
root.left.left.parent = root.left
root.left.right = BinaryTree(5)
root.left.right.parent = root.left
root.left.left.left = BinaryTree(6)
root.left.left.left.parent = root.left.left
node = root.left.right
nextNode = findSuccessor(root, node)
print(nextNode.value)
