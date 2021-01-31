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

'''
        root = program.BinaryTree(1)
        root.left = program.BinaryTree(2)
        root.left.parent = root
        root.right = program.BinaryTree(3)
        root.right.parent = root
        root.left.left = program.BinaryTree(4)
        root.left.left.parent = root.left
        root.left.right = program.BinaryTree(5)
        root.left.right.parent = root.left
        root.left.left.left = program.BinaryTree(6)
        root.left.left.left.parent = root.left.left
        node = root.left.right
        '''