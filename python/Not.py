import os

def create_note():
    note_name = input("Введите название заметки: ")
    note_content = input("Введите содержимое заметки: ")
    with open(note_name, "w") as f:
        f.write(note_content)

def read_notes():
    notes = os.listdir(".")
    for note in notes:
        if note.endswith(".txt"):
            with open(note, "r") as f:
                print(f.read())

def edit_note():
    note_name = input("Введите название заметки, которую хотите изменить: ")
    if os.path.exists(note_name):
        with open(note_name, "w") as f:
            new_content = input("Введите новое содержимое заметки: ")
            f.write(new_content)
    else:
        print("Заметка не найдена.")

def delete_note():
    note_name = input("Введите название заметки, которую хотите удалить: ")
    if os.path.exists(note_name):
        os.remove(note_name)
    else:
        print("Заметка не найдена.")

while True:
    print("""
Меню:
1. Создать заметку
2. Просмотреть список заметок
3. Редактировать заметку
4. Удалить заметку
5. Выйти из программы
        """)
    
    choice = input("Выберите пункт меню: ")
    
    if choice == "1":
        create_note()
    elif choice == "2":
        read_notes()
    elif choice == "3":
        edit_note()
    elif choice == "4":
        delete_note()
    elif choice == "5":
        break
    else:
        print("Неверный выбор.")
