# Repair Store Management System

![Logo of the App](path/to/logo.png)

## Description

The **Repair Store Management System** is a comprehensive application designed to manage repair orders for technicians. This system helps organize the repair process by:

- Tracking user machines and their repairs
- Monitoring monthly profit
- Automatically sending email notifications to users upon repair completion
- Simplifying invoice and report management

This coursework project is provided to a real firm for **free** and is open-source. You are welcome to use it for free; however, please do not abuse it or claim it as your own.

## Libraries Required

To run the application, you will need the following libraries:

- `sqlite-jdbc-3.46.1.3.jar`
- `activation.jar`
- `javax.mail.jar`
- **JDK 22 (Default)**



Номенклатурни таблици в текущата база данни:

    Categories
        Съдържа категории на продуктите, напр. „Къртачи“, „Ъглошлайфи“ и т.н.
        Използва се в Products за определяне на категорията на всеки продукт.
        Променя се рядко, тъй като категориите са стандартни и служат за организация и филтриране.

    Brands
        Съдържа марки на продукти като „Makita“, „Bosch“ и т.н.
        Използва се в Products за задаване на марката на всеки продукт.
        Данните в тази таблица остават относително постоянни, тъй като марките не се променят често.

    Shelfes
        Съдържа информация за наличните рафтове за съхранение (напр. „A1“, „B2“ и т.н.).
        Използва се в RepairOrders за управление на местоположението на всеки ремонтен артикул.
        Рафтовете и техните капацитети са стандартни и не се променят често.