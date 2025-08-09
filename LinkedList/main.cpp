//Implementation of Linked List in CPP
#include<iostream>
using namespace std;
// insert at beginning , at a position, at end, deletion at beginning , at a position or value, at end, Display
struct Node
{
        int data;
        struct Node* next;
};
Node* head=nullptr;
void insertBeginning(int val)
{
        Node *temp = new Node;
        temp->data=val;
        temp->next=head;
        head=temp; // Important Note: As long as there is a pointer pointing to the (new) memory there will be NO memory leak

}
void insertEnd(int val)
{
        Node *p= new Node;
        p->data=val;
        p->next=NULL;
        if(head==NULL)
        {
            insertBeginning(val);
        }
        Node *temp=head;
        while(temp->next!=NULL)
        {
                temp=temp->next;
        }
        temp->next=p;
}
void insertPos(int pos,int val)
{
        Node* temp=head;
        if(head==NULL)
        {
            if(pos==0)
                insertBeginning(val);
            else
                cout<<"Position out of bounds!\n";
            return;
        }
        for(int i=0;i<pos-1;i++)
        {
                if (temp == NULL) {
            cout << "Position out of bounds!\n";
            return;
        }
            temp=temp->next;
        }
        if (temp == NULL) {
            cout << "Position out of bounds!\n";
            return;
        }
        Node *p=new Node;
        p->data=val;
        p->next=temp->next;
        temp->next=p;

}
void deletionBeginning()
{
    if(head==NULL)
    {
        cout<<"There are no nodes!\n";
        return;
    }
    Node *temp=head;
    head=head->next;
    delete temp;
}
void deletionEnd()
{
        Node* temp=head;
        while(temp->next->next!=NULL)
        {
                temp=temp->next;
        }
        delete temp->next;
        temp->next=NULL;
}
void deletionpos(int pos)
{
        if(head==NULL)
        {
            cout<<"There are no nodes!\n";
            return;
        }
        if(pos==0)
        {
            deletionBeginning();
            return;
        }
        Node* temp=head;
        for(int i=0;i<pos-1;i++)
        {
                if(temp->next==NULL)
                {
                    cout<<"Position out of bounds!\n";
                    return;
                }
                temp=temp->next;
        }
        if(temp->next==NULL)
        {
            cout<<"Position out of bounds!\n";
            return;
        }
        Node *x=temp->next;
        temp->next=temp->next->next;
        delete x;
}
void Display()
{
        if(head==NULL)
        {
            cout<<"There are no elements!\n";
        }
        Node* temp=head;
        while(temp!=NULL)
        {
                cout<<temp->data<<" ";
                temp=temp->next;
        }
        cout<<endl;
}

int main()
{
        int val,pos;
        cout<<"---Enter number for operation---";
        cout<<"\n1)Insertion at beginning\n";
        cout<<"2)Insertion at end\n";
        cout<<"3)Insertion at position\n";
        cout<<"4)Deletion at beginning\n";
        cout<<"5)Deletion at end\n";
        cout<<"6)Deletion at position\n";
        cout<<"7)Display\n8)Exit\n";
        int ch;
        cin>>ch;
        while(1)
        {
                switch(ch)
                {
                        case 1:
                                cout<<"Enter value to insert:";
                                cin>>val;
                                insertBeginning(val);
                                break;
                        case 2:
                                cout<<"Enter value to insert:";
                                cin>>val;
                                insertEnd(val);
                                break;
                        case 3:
                                cout<<"Enter value to insert:";
                                cin>>val;
                                cout<<"Enter position to insert:";
                                cin>>pos;
                                insertPos(pos,val);
                                break;
                        case 4:
                                deletionBeginning();
                                break;
                        case 5:
                                deletionEnd();
                                break;
                        case 6:
                                cout<<"Enter position to delete:";
                                cin>>pos;
                                deletionpos(pos);
                                break;
                        case 7:
                                Display();
                                break;
                        case 8:
                                cout<<"Program End!\n";
                                return 0;
                        default:
                                cout<<"Enter valid number(1-8)!\n";
                }
                cout<<"Enter number for operation:";
                cin>>ch;
        }

}
