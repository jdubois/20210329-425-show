#!/bin/sh

# Color output
green() {
    printf "\033[32m$@${NC}\n"
}


# Execute commands
echo $(green "(1/2) Create service principal")
SUBSCRIPTION_ID=$(az account show --query id --output tsv --only-show-errors)
SERVICE_PRINCIPAL=$(az ad sp create-for-rbac --role="Contributor" --scopes="/subscriptions/$SUBSCRIPTION_ID" --sdk-auth --only-show-errors)
echo $(green "(2/2) Create secrets in GitHub")
gh secret set AZURE_CREDENTIALS -b"$SERVICE_PRINCIPAL"
echo $(green "Congratulations!")
