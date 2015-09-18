#!/bin/bash
function usage() {
    echo "submit-job.sh [env]"
    echo "	env - {test,stage,production}";
    exit 1;
}

# Check that ansible is installed
hash ansible-playbook 2>/dev/null || { echo >&2 "Ansible is required.\n$ sudo pip install ansible"; }
echo "ansible is properly installed"
