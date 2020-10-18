# Simple Contacts

<img alt="Logo" src="fastlane/metadata/android/en-US/images/icon.png" width="120" />

Forked the Simple Contacts app for an assignment to write UI tests on. You can find more about 
the app <a href='https://github.com/SimpleMobileTools/Simple-Contacts'>here on it's github page.</a>

You can find the Bitrise build page for this app, along with integrated UI tests <a href='https://app.bitrise.io/app/9c43abc294548403'>here</a>

Here is the Test Table

| Test ID  | Test Priority | Test Type | Test Case | Test Description| Test Method |
|:-------------:|:-------------:|:-------------:|:-------------:|:-------------|:-------------:|
| T001_P0 | P0 | E2E | Save a phone numer in a new contact | Verify that user can save a phone number into a new contact with new name | `test_E2E_AddContactToContactsList` |
| T002_P0 | P0 | E2E | Edit a number in a saved contact. | Verify that given a saved contact, user can edit the said contact to change the phone number | `test_E2E_EditContactInContactsList` |
| T003_P0 | P0 | E2E | Delete a saved contact. | Verify that user can save a phone number into a new contact with new name | `test_E2E_DeleteContactInContactsList` |
| T004_P0 | P0 | E2E | Search for a saved contact | Verify that given a saved contact, user can delete the aforementioned contact. | `test_E2E_SearchContactInContactsList` |
| T005_P0 | P0 | E2E | Group selected contacts into a new group | Verify that given multiple saved contacts, user can select a subset of the saved contacts and group them into a particular group | `test_E2E_ContactGroupingInContactsList` |
| T006_P1 | P1 | Corner Case | User tries to save a contact without filling in any information. | Verify that when user tries to save a contact without filing in either contact name or phone number, user is notified of the same and the contact is not saved. | `test_CornerCase_SavingContactWithoutAnyInfo` |



---

A simple app for creating or managing your contacts from any source. The contacts can be stored on your device only, but also synchronized via Google, or other accounts. You can display your favorite contacts on a separate list.