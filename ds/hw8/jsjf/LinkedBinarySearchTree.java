// Christopher Larson
// CSCI 337 Homework 8 Problem 10
// LinkedBinarySearchTree.java
// 10/20/14
//
// This program creates a LinkedBinarySearchTree.
package jsjf;

import jsjf.exceptions.*;

/**
 * LinkedBinarySearchTree implements the BinarySearchTreeADT interface 
 * with links.
 * 
 * @author Java Foundations
 * @version 4.0
 */
// Suppressing warnings for the entire class, since Comparable cast
// is used extensively in multiple methods
@SuppressWarnings("unchecked")
public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T>
    implements BinarySearchTreeADT<T>
{
    /**
     * Creates an empty binary search tree.
     */
    public LinkedBinarySearchTree() 
    {
        super();
    }
    
    /**
     * Creates a binary search with the specified element as its root.
     *
     * @param element the element that will be the root of the new binary
     *        search tree
     * @throws NonComparableElementException if element is not Comparable
     */
    public LinkedBinarySearchTree(T element) 
    {
        super(element);
        
        if (!(element instanceof Comparable))
            throw new NonComparableElementException(
                "LinkedBinarySearchTree");
    }
    
    /**
     * Adds the specified object to the binary search tree in the
     * appropriate position according to its natural order.  Note that
     * equal elements are added to the right.
     *
     * @param element the element to be added to the binary search tree
     * @throws NonComparableElementException if element is not Comparable
     */
    public void addElement(T element) 
    {
        // To be completed as a Programming Project
        if (!(element instanceof Comparable))
            throw new NonComparableElementException("LinkedBinarySearchTree");
    
        BinaryTreeNode<T> temp = new BinaryTreeNode<T>(element);
        BinaryTreeNode<T> current = root;
        boolean added = false;
        Comparable<T> comparableElement = (Comparable<T>)element;

        if (isEmpty())
            root = temp;
        else
        {
            while (!added)
            {
                if (comparableElement.compareTo(current.getElement()) < 0)
                {
                    if (current.getLeft() == null)
                    {
                        current.setLeft(temp);
                        added = true;
                    }
                    else
                    {
                        current = current.getLeft();
                    }
                }
                else
                {
                    if (current.getRight() == null)
                    {   
                        current.setRight(temp);
                        added = true;
                    }
                    else 
                        current = current.getRight();
                }
            }
        }

        modCount++;
    }
    
    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it.  Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary 
              search tree
     * @throws ElementNotFoundException if the target element is not found
     */
    public T removeElement(T targetElement)
    {
        T result = null;

        if (isEmpty())
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        else
        {
            BinaryTreeNode<T> parent = null;
            if (targetElement.equals(root.getElement())) 
            {
                result =  root.getElement();
                BinaryTreeNode<T> temp = replacement(root);
                if (temp == null)
                    root = null;
                else 
                {
                    root.setElement(temp.getElement());
                    root.setRight(temp.getRight());
                    root.setLeft(temp.getLeft());
                }

                modCount++;
            }
            else 
            {                
                parent = root;
                if (((Comparable)targetElement).compareTo(root.getElement()) < 0)
                    result = removeElement(targetElement, root.getLeft(), parent);
                else
                    result = removeElement(targetElement, root.getRight(), parent);
            }
        }
        
        return result;
    }
                
    /**
     * Removes the first element that matches the specified target
     * element from the binary search tree and returns a reference to
     * it.  Throws a ElementNotFoundException if the specified target
     * element is not found in the binary search tree.
     *
     * @param targetElement the element being sought in the binary 
              search tree
     * @param node the node from which to search
     * @param parent the parent of the node from which to search
     * @throws ElementNotFoundException if the target element is not found
     */
    private T removeElement(T targetElement, BinaryTreeNode<T> node, 
        BinaryTreeNode<T> parent)
    {
        T result = null;
        
        if (node == null)
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        else
        {
            if (targetElement.equals(node.getElement())) 
            {
                result =  node.getElement();
                BinaryTreeNode<T> temp = replacement(node);
                if (parent.getRight() == node)
                    parent.setRight(temp);
                else 
                    parent.setLeft(temp);

                modCount++;
            }
            else 
            {                
                parent = node;
                if (((Comparable)targetElement).compareTo(node.getElement()) < 0)
                    result = removeElement(targetElement, node.getLeft(), parent);
                else
                    result = removeElement(targetElement, node.getRight(), parent);
            }
        }
        
        return result;
    }
    
    /**
     * Returns a reference to a node that will replace the one
     * specified for removal.  In the case where the removed node has 
     * two children, the inorder successor is used as its replacement.
     *
     * @param node the node to be removed
     * @return a reference to the replacing node
     */
    private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) 
    {
        BinaryTreeNode<T> result = null;
        
        if ((node.getLeft() == null) && (node.getRight() == null))
            result = null;
        
        else if ((node.getLeft() != null) && (node.getRight() == null))
            result = node.getLeft();
        
        else if ((node.getLeft() == null) && (node.getRight() != null))
            result = node.getRight();
        
        else
        {
            BinaryTreeNode<T> current = node.getRight();
            BinaryTreeNode<T> parent = node;
            
            while (current.getLeft() != null)
            {
                parent = current;
                current = current.getLeft();
            }
            
            current.setLeft(node.getLeft());
            if (node.getRight() != current)
            {
                parent.setLeft(current.getRight());
                current.setRight(node.getRight());
            }
            
            result = current;
        }
        
        return result;
    }
    
    /**
     * Removes elements that match the specified target element from 
     * the binary search tree. Throws a ElementNotFoundException if 
     * the sepcified target element is not found in this tree.
     *
     * @param targetElement the element being sought in the binary 
              search tree
     * @throws ElementNotFoundException if the target element is not found
     */
    public void removeAllOccurrences(T targetElement)
    {
        removeElement(targetElement);
        
        try
        {
            while (contains((T)targetElement))
                removeElement(targetElement);
        }
        
        catch (Exception ElementNotFoundException)
        {
        }
    }

    /**
     * Removes the node with the least value from the binary search
     * tree and returns a reference to its element.  Throws an
     * EmptyCollectionException if this tree is empty. 
     *
     * @return a reference to the node with the least value
     * @throws EmptyCollectionException if the tree is empty
     */
    public T removeMin() 
    {
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else 
        {
            T result;
            if (root.getLeft() == null) 
            {
                result = root.getElement();
                root = root.getRight();
            }
            else 
            {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current;
                for (current = root.getLeft(); current.getLeft() != null; 
                    current = current.getLeft())
                        parent = current;
                result =  current.getElement();
                parent.setLeft(current.getRight());
            }

            modCount++;
            return result;
        }
    }

    /**
     * Removes the node with the highest value from the binary
     * search tree and returns a reference to its element.  Throws an
     * EmptyCollectionException if this tree is empty. 
     *
     * @return a reference to the node with the highest value
     * @throws EmptyCollectionException if the tree is empty
     */
    public T removeMax() 
    {
        // To be completed as a Programming Project
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");
        else 
        {
            T result;
            if (root.getRight() == null) 
            {
                result = root.getElement();
                root = root.getLeft();
            }
            else 
            {
                BinaryTreeNode<T> parent = root;
                BinaryTreeNode<T> current;
                for (current = root.getRight(); current.getRight() != null; 
                    current = current.getRight())
                        parent = current;
                result =  current.getElement();
                parent.setRight(current.getLeft());
            }

            modCount++;
            return result;
        }
    }

    /**
     * Removes the node with the highest value from the binary
     * search tree and returns a reference to its element.  Throws an
     * EmptyCollectionException if this tree is empty. 
    }

    /**
     * Returns the element with the least value in the binary search
     * tree. It does not remove the node from the binary search tree. 
     * Throws an EmptyCollectionException if this tree is empty.
     *
     * @return the element with the least value
     * @throws EmptyCollectionException if the tree is empty
     */
    public T findMin() 
    {
        // To be completed as a Programming Project
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");

        BinaryTreeNode<T> current = root;

        while (current.getLeft() != null)
            current = current.getLeft();

        return current.getElement();
    }

    /**
     * Returns the element with the highest value in the binary
     * search tree.  It does not remove the node from the binary
     * search tree.  Throws an EmptyCollectionException if this 
     * tree is empty.
     *
     * @return the element with the highest value
     * @throws EmptyCollectionException if the tree is empty
     */
    public T findMax() 
    {
        // To be completed as a Programming Project
        if (isEmpty())
            throw new EmptyCollectionException("LinkedBinarySearchTree");

        BinaryTreeNode<T> current = root;

        while (current.getRight() != null)
            current = current.getRight();

        return current.getElement();
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in the binary tree.  Throws a NoSuchElementException if
     * the specified target element is not found in this tree.
     *
     * @param targetElement the element being sough in the binary tree
     * @throws ElementNotFoundException if the target element is not found
     * @throws NonComparableElementException if the target is not Comparable
     */
    public T find(T targetElement) 
    {
        // To be completed as a Programming Project
        if (!(targetElement instanceof Comparable))
            throw new NonComparableElementException("LinkedBinarySearchTree"); 

        Comparable<T> comparableElement = (Comparable<T>)targetElement;
        BinaryTreeNode<T> current = root;

        while (current != null 
            && (!(comparableElement.equals(current.getElement()))))
        {
            if (comparableElement.compareTo(current.getElement()) < 0)
                current = current.getLeft();
            else
                current = current.getRight();
        }

        if (current == null)
            throw new ElementNotFoundException("LinkedBinarySearchTree");
        else 
            return current.getElement();
    }
}

